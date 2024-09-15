import React from 'react';
import PlanTable from './components/PlanTable';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img align = "left" src={`${process.env.PUBLIC_URL}/telstra-logo.jfif`} alt="Telstra Logo" className="org-logo" />
        <br></br>
        <br></br>
        <h3 align = "left">Your current plan is: Basic Plan</h3>
      </header>
      <PlanTable />
      <footer>
        © {new Date().getFullYear()} Telstra - All Rights Reserved
      </footer>
    </div>
  );
}

export default App;
