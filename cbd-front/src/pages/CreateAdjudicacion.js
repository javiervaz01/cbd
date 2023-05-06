import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Styles.css'

function NewAdjudicacionButton() {
  const [showForm, setShowForm] = useState(false);
  const [propuesta, setPropuesta] = useState('');
  const [selectedAlumno, setSelectedAlumno] = useState('');
  const [estado, setEstado] = useState('');
  const [nombreProfesor, setNombreProfesor] = useState('');

  const [alumnos, setAlumnos] = useState([]);
  const [propuestas, setPropuestas] = useState([]);
  const [selectedPropuesta, setSelectedPropuesta] = useState("");

  useEffect(() => {
    axios.get('http://localhost:8080/alumnos').then(response => {
      setAlumnos(response.data);
    });
    axios.get('http://localhost:8080/propuestas').then(response => {
      setPropuestas(response.data);
    });

  }, []);



  const handleSubmit = async (event) => {
    event.preventDefault();

    const nuevoEstado = '{"estado":"'+estado+'"}'

    const data = {
      propuesta: selectedPropuesta,
      alumno: selectedAlumno,
      estado: nuevoEstado
    };
    axios.post('http://localhost:8080/adjudicaciones', data)
      .then(response => {
        console.log('Adjudicacion creada exitosamente');
        setShowForm(false);
        // Reload the page to show the new Propuesta
        window.location.reload();
      })
      .catch(error => {
        console.error(error);
      });
  };

  const handlePropuestaChange = (event) => {
    const selectedPropuesta = propuestas.find((propuesta) => propuesta.titulo === event.target.value);
    setSelectedPropuesta(selectedPropuesta);
  }
  const handleAlumnoChange = (event) => {
    const selectedAlumno = alumnos.find((alumno) => alumno.nombre === event.target.value);
    setSelectedAlumno(selectedAlumno);
  }


  return (
    <div className="newPropuestaButton">
      {showForm ?
        <form onSubmit={handleSubmit} className="formContainer">
          <label>Propuesta:</label>
          <select id="propuesta" value={selectedPropuesta.titulo} onChange={handlePropuestaChange}>
        <option value="">--Selecciona una propuesta--</option>
        {propuestas.map(propuesta => (
          <option key={propuesta.id} value={propuesta.titulo}>{propuesta.titulo}</option>
        ))}
      </select>

          <label>Alumno:</label>
          <select id="alumno" value={selectedAlumno.nombre} onChange={handleAlumnoChange}>
        <option value="">--Selecciona un alumno--</option>
        {alumnos.map(alumno => (
          <option key={alumno.id} value={alumno.nombre}>{alumno.nombre}</option>
        ))}
      </select>
          <label>Estado:</label>
          <input type="text" value={estado} onChange={(e) => setEstado(e.target.value)} required />

         

          <button type="submit" style={{ marginRight: "10px" }}>Crear</button>
          <button onClick={() => setShowForm(false)}>Cancelar</button>
        </form>
        :
        <button onClick={() => setShowForm(true)}>Nueva Adjudicacion</button>
      }
    </div>
  );
}

export default NewAdjudicacionButton;
