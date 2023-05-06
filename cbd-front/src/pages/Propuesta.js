import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Sidebar from "../components/Sidebar";
import "./Styles.css";

function PropuestaDetails() {
    const { id } = useParams();
    const [propuesta, setPropuesta] = useState({});
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [showEditForm, setShowEditForm] = useState(false);

    // Add useEffect hook to load the propuesta data
    useEffect(() => {
        axios.get(`http://localhost:8080/propuestas/${id}`)
            .then(response => {
                setPropuesta(response.data);
                setLoading(false);
            })
            .catch(error => {
                console.error(error);
                setError(error.message);
                setLoading(false);
            });
    }, [id]);

    const handleEdit = () => {
        setShowEditForm(true);
      };

        const upload = () => {
            axios.put(`http://localhost:8080/propuestas/${id}`, {
                titulo: titulo,
                descripcion: descripcion,
            })
                .then(response => {
                    console.log('Propuesta actualizada correctamente');
                })
                .catch(error => {
                    console.error(error);
                });
                setShowEditForm(false);

        };

          const {
        titulo,
        descripcion,
        handleTituloChange,
        handleDescripcionChange,
        handleSubmit,
    } = useEditPropuesta(propuesta);

    // Add a function to handle the delete button click
    const handleDelete = () => {
        if (window.confirm('Estas seguro que quieres eliminar esta propuesta?')) {
            axios.delete(`http://localhost:8080/propuestas/${id}`)
                .then(response => {
                    console.log('Propuesta eliminada correctamente');
                    // TODO: redirect to the previous page or show a message
                })
                .catch(error => {
                    console.error(error);
                });
        }
    };

    if (loading) {
        return <p>Loading...</p>;
    }

    if (error) {
        return <p>Error: {error}</p>;
    }

    return (
<div className="app">
        <div className="right">
                    <div className="titulo">
                        <h1>Propuesta</h1>
                    </div>
                    <Sidebar />

                    
                </div>

        <div className="content">
            
        <div className="propuesta-details">
        <div className="propuesta-card">
          <h2>{propuesta.titulo}</h2>
          <p>{propuesta.descripcion}</p>
          <p>Profesor: {propuesta.profesor.nombre} {propuesta.profesor.apellidos}</p>
          <p>Departamento: {propuesta.departamento}</p>
          <div className="propuesta-card-actions">
            <button className="btn btn-primary" onClick={handleEdit}>Edit</button>
            <button className="btn btn-danger" onClick={handleDelete}>Delete</button>
          </div>
        </div>
      </div>
        </div>
        {showEditForm && (
        <div className="edit-form">
          <form onSubmit={handleSubmit}>
            <label>
              Titulo:
              <input
                type="text"
                value={titulo}
                onChange={handleTituloChange}
              />
            </label>
            <label>
              Descripcion:
              <input
                type="text"
                value={descripcion}
                onChange={handleDescripcionChange}
              />
            </label>
            <button type="submit" onClick={upload}>Save</button>
          </form>
        </div>
      )}
        </div>

      
    );
}


function useEditPropuesta(propuesta) {
    const [titulo, setTitulo] = useState(propuesta.titulo);
    const [descripcion, setDescripcion] = useState(propuesta.descripcion);
  
    const handleTituloChange = (event) => {
      setTitulo(event.target.value);
    };
  
    const handleDescripcionChange = (event) => {
      setDescripcion(event.target.value);
    };
  
    const handleSubmit = (event) => {
      event.preventDefault();
      // Do something with the updated propuesta data
    };
  
    return {
      titulo,
      descripcion,
      handleTituloChange,
      handleDescripcionChange,
      handleSubmit,
    };
  }

export default PropuestaDetails;
