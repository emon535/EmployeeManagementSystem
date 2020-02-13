import React from 'react'

const EmployeeTable = (props) => (
    <table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Email Address</th>
                <th>Contact Number</th>
                <th>Gender</th>
                <th>Birthday</th>
                <th>Actions</th>

            </tr>
        </thead>
        <tbody>
            {props.employee.length > 0 ? (
                props.employee.map(employee => (
                    <tr key={employee.id}>
                        <td>{employee.name}</td>
                        <td>{employee.email}</td>
                        <td>{employee.contractNumber}</td>
                        <td>{employee.gender}</td>
                        <td>{employee.birthday}</td>
                        {/* <td>{employee.programmingLanguage[0]}, {employee.programmingLanguage[1]}</td> */}
                        <td>
                            <button
                                onClick={() => {
                                    props.editRow(employee)
                                }}
                                className="button muted-button"
                            >
                                Edit
                            </button>
                            <button onClick={() => props.deleteUser(employee.id)} className="button muted-button">
                                Delete
                            </button>
                        </td>
                    </tr>
                ))
            ) : (
                    <tr>
                        <td colSpan={3}>No Employee Found, Please Add new</td>
                    </tr>
                )}
        </tbody>
    </table>
)

export default EmployeeTable;