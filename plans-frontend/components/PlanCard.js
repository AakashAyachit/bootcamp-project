import React from 'react';
import './PlanCard.css';

const PlanCard = ({ plan, type }) => {
  if (type === 'Data Plan') {
    return (
      <div className="plan-card combined-data-plan">
        <h4>{type}</h4>
        <div className="data-plans-container">
          {plan.map((dataPlan, index) => (
            <div key={index} className="individual-data-plan">
              <h4>{dataPlan.name}</h4>
              <p>{dataPlan.description}</p>
              <p><strong>Price:</strong> ${dataPlan.price.toFixed(2)}</p>
              <p><strong>Data Limit:</strong> {dataPlan.dataLimit === 'Unlimited' ? 'Unlimited' : `${dataPlan.dataLimit}GB/day`}</p>
              <button>Select {dataPlan.name}</button>
            </div>
          ))}
        </div>
      </div>
    );
  }

  return (
    <div className="plan-card">
      <h4>{type}</h4>
      <h4>{plan.name}</h4>
      <p>{plan.description}</p>
      <p><strong>Price:</strong> ${plan.price.toFixed(2)}</p>
      {type === 'Calling Plan' && <p><strong>Minutes:</strong> {plan.minutes}</p>}
      {type === 'Combo Plan' && (
        <>
          <p><strong>Minutes:</strong> {plan.minutes}</p>
          <p><strong>Data Limit:</strong> {plan.dataLimit}</p>
          <p><strong>TV Included:</strong> {plan.tvIncluded ? 'Yes' : 'No'}</p>
        </>
      )}
      <button>Select Plan</button>
    </div>
  );
};

export default PlanCard;
