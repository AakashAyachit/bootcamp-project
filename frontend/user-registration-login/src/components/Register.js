import React from 'react';

import * as Yup from 'yup';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import {  useState } from "react";

// const Register = () => {
//   const navigate = useNavigate();

//   const initialValues = {
//     fullname: '',
//     email: '',
//     password: '',
//     aadhaarNumber: '',
//     phone: '',
//   };

//   const validationSchema = Yup.object({
//     fullname: Yup.string().required('Full name is required'),
//     email: Yup.string().email('Invalid email format').required('Email is required'),
//     password: Yup.string().min(8, 'Password must be at least 8 characters').required('Password is required'),
//     aadhaarNumber: Yup.string().length(12, 'Aadhaar must be 12 digits').required('Aadhaar number is required'),
//     phone: Yup.string().length(10, 'Phone number must be 10 digits').required('Phone number is required'),
//   });

//   const onSubmit = async (values, actions) => {
//     console.log('Submitting form with values:', values);  // Log the values to ensure everything is correct
//     try {
//       await axios.post('http://localhost:9005/auth/register', values);  // Use 'values' instead of 'initialValues'
//       navigate('/login');
//     } catch (error) {
//       console.error('There was an error registering the user!', error);
//     }
//     actions.setSubmitting(false);
//   };

function Register() {
  
    const [fullName, setfullName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [phoneNumber, setphoneNumber] = useState("");
    const [aadhaarNumber, setaadhaarNumber] = useState("");
    async function save(event) {
        event.preventDefault();
        try {
          await axios.post("http://localhost:9005/auth/register", {
          fullName: fullName,
          email: email,
          password: password,
          phoneNumber:phoneNumber,
          aadhaarNumber:aadhaarNumber
          });
          alert("Employee Registation Successfully");
        } catch (err) {
          alert(err);
        }
      }

      return (
        <div>
        <div className="form-container">
        <div>
                <h1>Registation</h1>
        
        <form>
            <div class="form-group">
              <label>Name</label>
              <input type="text" id="fullname" name="fullname"  placeholder="Enter Name"
              
              value={fullName}
              onChange={(event) => {
                setfullName(event.target.value);
              }}
              />
            </div>
            <div class="form-group">
              <label>email</label>
              <input type="email"  id="email" name="email" placeholder="Enter Email"
              
              value={email}
              onChange={(event) => {
                setEmail(event.target.value);
              }}
              
              />

</div>
            <div class="form-group">
              <label>Aadhaar</label>
              <input type="text" id="aadhaar" name="aadhaar" placeholder="Enter aadhaar number"
              
              value={aadhaarNumber}
              onChange={(event) => {
                setaadhaarNumber(event.target.value);
              }}
              
              />

</div>
            <div class="form-group">
              <label>Phone</label>
              <input type="text"  id="phone" name="phone" placeholder="Enter Phone number"
              
              value={phoneNumber}
              onChange={(event) => {
                setphoneNumber(event.target.value);
              }}
              
              />
     
            </div>
            <div class="form-group">
                <label>password</label>
                <input type="password"  id="password" name="password" placeholder="Enter password"
                
                value={password}
                onChange={(event) => {
                  setPassword(event.target.value);
                }}
                
                />
              </div>
            <button type="submit" onClick={save} >Register</button>
           
          </form>
        </div>
        </div>
         </div>
        );
      }
      
      export default Register;
//   return (
//     <div className="form-container">
//       <h2>Register</h2>
      
//           <form>
//             <div>
//               <label htmlFor="fullname">Full Name</label>
//               <Field type="text" id="fullname" name="fullname" />
//               <ErrorMessage name="fullname" component="div" />
//             </div>

//             <div>
//               <label htmlFor="email">Email</label>
//               <Field type="email" id="email" name="email" />
//               <ErrorMessage name="email" component="div" />
//             </div>

//             <div>
//               <label htmlFor="password">Password</label>
//               <Field type="password" id="password" name="password" />
//               <ErrorMessage name="password" component="div" />
//             </div>

//             <div>
//               <label htmlFor="aadhaar">Aadhaar</label>
//               <Field type="text" id="aadhaar" name="aadhaar" />
//               <ErrorMessage name="aadhaar" component="div" />
//             </div>

//             <div>
//               <label htmlFor="phone">Phone</label>
//               <Field type="text" id="phone" name="phone" />
//               <ErrorMessage name="phone" component="div" />
//             </div>

//             <button type="submit">Register</button>
//           </form>
       
//     </div>
//   );
// };

// export default Register;
