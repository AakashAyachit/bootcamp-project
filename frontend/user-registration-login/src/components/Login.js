import React from 'react';
import { Formik, Form, Field, ErrorMessage } from 'formik';
import * as Yup from 'yup';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const navigate = useNavigate();

  const initialValues = {
    aadhaarNumber: '',
    password: '',
  };

  const validationSchema = Yup.object({
    aadhaarNumber: Yup.string().length(12, 'Aadhaar must be 12 digits').required('Aadhaar number is required'),
    password: Yup.string().required('Password is required'),
  });

  const onSubmit = async (values) => {
    console.log('Login form submitted with:', values);
    try {
      const response = await axios.post('http://localhost:9005/auth/login', values);
      localStorage.setItem('token', response.data.token); // Store JWT token
      navigate('/home');
    } catch (error) {
      console.error('There was an error logging in!', error);
    }
  };

  return (
    <div className="form-container">
      <h2>Login</h2>
      <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={onSubmit}>
        <Form>
          <div>
            <label htmlFor="aadhaar">Aadhaar</label>
            <Field type="text" id="aadhaarNumber" name="aadhaarNumber" />
            <ErrorMessage name="aadhaarNumber" component="div" />
          </div>

          <div>
            <label htmlFor="password">Password</label>
            <Field type="password" id="password" name="password" />
            <ErrorMessage name="password" component="div" />
          </div>

          <button type="submit">Login</button>
        </Form>
      </Formik>
    </div>
  );
};

export default Login;
