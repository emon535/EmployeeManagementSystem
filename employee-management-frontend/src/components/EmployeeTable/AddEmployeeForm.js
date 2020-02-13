import React, { useState } from 'react'

const AddEmployeeForm = props => {
    const initialFormState = {
        id: "",
        name: "",
        contractNumber: "",
        email: "",
        gender: "OTHER",
        birthday: "",
        imagePath: "https://dummyimage.com/100/000/fff",
        programmingLanguage: [
            "ReactJS",
            "Java SpringBoot"
        ],
        presentAddress: "Some text"
    }

    const [user, setUser] = useState(initialFormState)

    const handleInputChange = event => {
        const { name, email, contractNumber, gender, birthday, imagePath, value } = event.target
        setUser({ ...user, [name]: value, [email]: value, [contractNumber]: value, [gender]: value, [birthday]: value, [imagePath]: value })

    }

    return (
        <form onSubmit={event => {
            event.preventDefault()
            if (!user.name || !user.email) return

            props.addEmployee(user)
            setUser(initialFormState)
        }}
        >
            <label>Name: </label>
            <input type="text" name="name" value={user.name} onChange={handleInputChange} /><br /><br />
            <label>Email: </label>
            <input type="text" name="email" value={user.email} onChange={handleInputChange} /><br /><br />
            <label>Phone Number: </label>
            <input type="text" name="contractNumber" value={user.contractNumber} onChange={handleInputChange} /><br /><br />
            <label>Gender: </label>
            <select type="text" name="gender" value={user.gender} onChange={handleInputChange} >
                <option value="MALE">MALE</option>
                <option value="FEMALE">FEMALE</option>
                <option value="OTHER">OTHER</option>
            </select>
            <br /><br />
            <label>Birthday: </label>
            <input type="text" name="birthday" value={user.birthday} onChange={handleInputChange} /><br /><br />
            {/* <label>Programming Language: </label> */}
            {/* <input type="text" name="programmingLanguage" value={user.programmingLanguage} onChange={handleInputChange} /><br /><br /> */}
            <button>Add new user</button>
        </form>
    )
}

export default AddEmployeeForm;