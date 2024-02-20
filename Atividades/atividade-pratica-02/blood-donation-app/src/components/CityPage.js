import React, { useState, useEffect } from 'react';
import CityForm from './CityForm';
import axios from 'axios'; // Assuming axios is installed
import '../styles/CityPage.css'; // Import custom CSS

const CityPage = () => {
  const [estados, setEstados] = useState([]);
  const [selectedEstadoId, setSelectedEstadoId] = useState(null);

  useEffect(() => {
    const fetchEstados = async () => {
      //const response = await axios.get('http://localhost:8080/estados');
      //setEstados(response.data);
    };
    fetchEstados();
  }, []);

  const handleFormSubmit = (cityData) => {
    cityData.estadoId = selectedEstadoId;
    // Replace with your API call to create the city
    console.log('Submitted city data:', cityData);
  };

  return (
    <div className="city-page">
      <h1>Cadastrar Cidade</h1>
      <CityForm estados={estados} onEstadoChange={setSelectedEstadoId} onSubmit={handleFormSubmit} />
    </div>
  );
};

export default CityPage;