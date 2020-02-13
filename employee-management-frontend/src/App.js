import React, { useState, Fragment, useEffect } from 'react';
import logo from './logo.svg';
import './App.css';
import EmployeeTable from './components/EmployeeTable/EmployeeTable';
import AddEmployeeForm from './components/EmployeeTable/AddEmployeeForm';
import EditEmployeeForm from './components/EmployeeTable/EditEmployeeForm';
import axios from "axios";

function App() {


  const employeeListData = [
    {
      id: "d134edb4-d36c-441d-9ff7-5b521cee3216",
      name: "FAKE",
      contractNumber: "01712214937",
      email: "Something@gmail.com",
      gender: "MALE",
      birthday: "Some text",
      imagePath: "Some text",
      programmingLanguage: [
        "A",
        "B"
      ],
      presentAddress: "Some text"
    }
  ]

  useEffect(() => {
    fetch(
      `http://localhost:8080/api/v1/employee/`
    )
      .then(res => res.json())
      .then(response => {
        getEmployee(response);
      })
      .catch(error => console.log(error));
  });



  const initialFormState = {
    id: "",
    name: "",
    contractNumber: "",
    email: "",
    gender: "",
    birthday: "",
    imagePath: "",
    programmingLanguage: [],
    presentAddress: ""
  }



  const [employee, getEmployee] = useState(employeeListData)
  const [editing, setEditing] = useState(false)
  const [currentEmployee, setCurrentEmployee] = useState(initialFormState)
  const [newEmployee, postNewEmployee] = postEmployeeEndPoints();


  const addEmployee = user => {
    user = postNewEmployee(user)
    console.log(user);
  }

  const deleteUser = id => {
    getEmployee(employee.filter(user => user.id !== id))
  }

  const editRow = user => {
    setEditing(true)
    setCurrentEmployee({ id: user.id, name: user.name, username: user.username })
  }

  const updateEmployee = (id, updatedUser) => {
    setEditing(false)
    getEmployee(employee.map(user => (user.id === id ? updatedUser : user)))
  }



  return (
    <div className="container">
      <h1>Employee Management React App</h1>
      <div className="flex-row">
        <div className="flex-large bordered w30 left">
          {editing ? (
            <div>
              <h2>Edit user</h2>
              <EditEmployeeForm
                editing={editing}
                setEditing={setEditing}
                currentEmployee={currentEmployee}
                updateEmployee={updateEmployee}
              />
            </div>
          ) : (
              <div>
                <h2>Add Employee</h2>
                <AddEmployeeForm addEmployee={addEmployee} />
              </div>
            )}
        </div>
        <div className="flex-large bordered left w40">
          <h2>View Employee</h2>
          <EmployeeTable employee={employee} editRow={editRow} deleteUser={deleteUser} />
        </div>

      </div>
    </div>
  );
}


const employeeApi = "http://localhost:8080/api/v1/employee/";


function postEmployeeEndPoints() {
  /* eslint-disable react-hooks/rules-of-hooks */
  return useAsyncEndpoint(data => ({
    url: employeeApi,
    method: "POST",
    data
  }));
}



function useAsyncEndpoint(fn) {
  const [res, setRes] = useState({
    data: null,
    complete: false,
    pending: false,
    error: false
  });
  const [req, setReq] = useState();

  useEffect(
    () => {
      if (!req) return;
      setRes({
        data: null,
        pending: true,
        error: false,
        complete: false
      });
      axios(req)
        .then(res =>
          setRes({
            data: res.data,
            pending: false,
            error: false,
            complete: true
          })
        )
        .catch(() =>
          setRes({
            data: null,
            pending: false,
            error: true,
            complete: true
          })
        );
    },
    [req]
  );

  return [res, (...args) => setReq(fn(...args))];
}


export default App;
