import React, { useState, useEffect } from 'react'


const EditEmployeeForm = props => {


    useEffect(
        () => {
            setEmployee(props.currentEmployee)
        },
        [props]
    )

    const [employee, setEmployee] = useState(props.currentEmployee)
    const handleInputChange = event => {
        const { name, email, contractNumber, gender, birthday, imagePath, value } = event.target

        setEmployee({ ...employee, [name]: value, [email]: value, [contractNumber]: value, [gender]: value, [birthday]: value, [imagePath]: value })
    }

    return (
        <form
            onSubmit={event => {
                event.preventDefault()

                props.updateEmployee(employee.id, employee.name, employee.email, employee.contactNumber, employee.gender, employee.birthday, employee.programmingLanguage)
            }}
        >
            <label>Name</label>
            <input type="text" name="name" value={employee.name} onChange={handleInputChange} /> <br /><br />
            <label>Email: </label>
            <input type="text" name="email" value={employee.email} onChange={handleInputChange} /><br /><br />
            <label>Phone Number: </label>
            <input type="text" name="contactNumber" value={employee.contactNumber} onChange={handleInputChange} /><br /><br />
            <label>Gender: </label>
            <select type="text" name="gender" value={employee.gender} onChange={handleInputChange} >
                <option value="MALE">MALE</option>
                <option value="FEMALE">FEMALE</option>
                <option value="OTHER">OTHER</option>
            </select><br /><br />
            <label>Birthday: </label>
            <input type="text" name="birthday" value={employee.birthday} onChange={handleInputChange} /><br /><br />
            {/* <label>Programming Language</label> */}
            {/* <input type="text" name="programmingLanguage" value={user.programmingLanguage} onChange={handleInputChange} /> */}
            <button>Update Employee</button>
            <button onClick={() => props.setEditing(false)} className="button muted-button">
                Cancel
      </button>
        </form>
    )
}

export default EditEmployeeForm