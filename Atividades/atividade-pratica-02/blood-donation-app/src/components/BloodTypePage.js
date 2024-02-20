import React, { useState } from 'react';
import BloodTypeForm from './BloodTypeForm';
//import '../styles/BloodTypePage.css'; // Import custom CSS

const BloodTypePage = () => {
  const [showSuccessMessage, setShowSuccessMessage] = useState(false);

  const handleFormSubmit = () => {
    setShowSuccessMessage(true); // Simulate successful submission
    setTimeout(() => setShowSuccessMessage(false), 5000); // Hide message after 5 seconds
  };

  return (
    <div className="blood-type-page">
      <h1 className="title">Adicionar Tipo Sanguíneo</h1>
      <BloodTypeForm onSubmit={handleFormSubmit} />
      {showSuccessMessage && (
        <div className="success-message">
          Tipo sanguíneo adicionado com sucesso! 
        </div>
      )}
    </div>
  );
};

export default BloodTypePage;
