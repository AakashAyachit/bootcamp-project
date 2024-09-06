import React, { useEffect, useState } from 'react';
import axios from 'axios';
import PlanCard from './PlanCard';
import './PlanTable.css';

const PlanTable = () => {
  const [plans, setPlans] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:4545/api/plans/select-plan')
      .then(response => {
        setPlans(response.data);
      })
      .catch(error => {
        console.error('Error fetching plans:', error);
      });
  }, []);

  if (!plans) {
    return <p>Loading plans...</p>;
  }

  return (
    <div className="plan-table">
      <PlanCard plan={plans.callingPlan} type="Calling Plan" />
      <PlanCard plan={plans.dataPlans} type="Data Plan" />
      <PlanCard plan={plans.comboPlan} type="Combo Plan" />
    </div>
  );
};

export default PlanTable;
