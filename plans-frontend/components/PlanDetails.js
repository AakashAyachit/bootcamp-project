import React from 'react';

const PlanDetails = ({ data }) => {
  return (
    <div className="plan-details">
      <p><strong>Data:</strong> {data.data}</p>
      <p><strong>Talk Time:</strong> {data.talkTime}</p>
      <ul>
        {data.features.map((feature, index) => (
          <li key={index}>{feature}</li>
        ))}
      </ul>
    </div>
  );
};

export default PlanDetails;
