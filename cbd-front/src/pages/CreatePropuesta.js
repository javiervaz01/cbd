import React, { useState } from 'react';
import axios from 'axios';
import './Styles.css'

function NewPropuestaButton() {
  const [showForm, setShowForm] = useState(false);
  const [titulo, setTitulo] = useState('');
  const [descripcion, setDescripcion] = useState('');
  const [nombreProfesor, setNombreProfesor] = useState('');
  const [departamento, setDepartamento] = useState('');

  const getProfesorByName = async (nombre) => {
    try {
        debugger;
      const response = await axios.get(`http://localhost:8080/profesores/nombre/${nombre}`);
      const profesorNombre = response.data;
      return profesorNombre;
    } catch (error) {
      console.error(error);
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    const profesorReal = await getProfesorByName(nombreProfesor);

    const data = {
      titulo: titulo,
      descripcion: descripcion,
      profesor: profesorReal,
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

  return (
    <div className="newPropuestaButton">
      {showForm ?
        <form onSubmit={handleSubmit} className="formContainer">
          <label>Titulo:</label>
          <input type="text" value={titulo} onChange={(e) => setTitulo(e.target.value)} required />

          <label>Descripcion:</label>
          <textarea value={descripcion} onChange={(e) => setDescripcion(e.target.value)} required />

          <label>Nombre del profesor:</label>
          <input type="text" value={nombreProfesor} onChange={(e) => setNombreProfesor(e.target.value)} required />

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
