import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Styles.css'

function NewPropuestaButton() {
  const [showForm, setShowForm] = useState(false);
  const [titulo, setTitulo] = useState('');
  const [descripcion, setDescripcion] = useState('');
  const [nombreProfesor, setNombreProfesor] = useState('');
  const [departamento, setDepartamento] = useState('');

  const [profesores, setProfesores] = useState([]);
  const [selectedProfesor, setSelectedProfesor] = useState("");
  

  const handleProfesorChange = (event) => {
    const selectedProfesor = profesores.find((profesor) => profesor.nombre === event.target.value);
    debugger;
    setSelectedProfesor(selectedProfesor);
  }

  const handleSubmit = async (event) => {
    event.preventDefault();

    const data = {
      titulo: titulo,
      descripcion: descripcion,
      profesor: selectedProfesor,
      departamento: departamento
    };
    axios.post('http://localhost:8080/propuestas', data)
      .then(response => {
        console.log('Propuesta creada exitosamente');
        setShowForm(false);
        // Reload the page to show the new Propuesta
        window.location.reload();
      })
      .catch(error => {
        console.error(error);
      });
  };

  useEffect(() => {
    axios.get('http://localhost:8080/profesores').then(response => {
      setProfesores(response.data);
    });

  }, []);


  return (
    <div className="newPropuestaButton">
      {showForm ?
        <form onSubmit={handleSubmit} className="formContainer">
          <label>Titulo:</label>
          <input type="text" value={titulo} onChange={(e) => setTitulo(e.target.value)} required />

          <label>Descripcion:</label>
          <textarea value={descripcion} onChange={(e) => setDescripcion(e.target.value)} required />

          <label>Profesor:</label>
          <select id="profesor" value={selectedProfesor.nombre} onChange={handleProfesorChange}>
        <option value="">--Selecciona un profesor--</option>
        {profesores.map(profesor => (
          <option key={profesor.id} value={profesor.nombre}>{profesor.nombre}</option>
        ))}
      </select>
          <label>Departamento:</label>
          <input type="text" value={departamento} onChange={(e) => setDepartamento(e.target.value)} required />

          <button type="submit" style={{ marginRight: "10px" }}>Crear</button>
          <button onClick={() => setShowForm(false)}>Cancelar</button>
        </form>
        :
        <button onClick={() => setShowForm(true)}>Nueva Propuesta</button>
      }
    </div>
  );
}

export default NewPropuestaButton;
