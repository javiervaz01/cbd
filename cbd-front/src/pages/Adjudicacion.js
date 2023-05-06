import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import Sidebar from "../components/Sidebar";
import "./Styles.css";

function AdjudicacionDetails() {
    const { id } = useParams();
    const [adjudicacion, setAdjudicacion] = useState({});
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [showEditForm, setShowEditForm] = useState(false);

    

    // Add useEffect hook to load the adjudicacion data
    useEffect(() => {
        axios.get(`http://localhost:8080/adjudicaciones/${id}`)
            .then(response => {
                setAdjudicacion(response.data);
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
            axios.put(`http://localhost:8080/adjudicaciones/${id}`, {
                estado: estado
            })
                .then(response => {
                    console.log('Estado de la adjudicación actualizada correctamente');
                })
                .catch(error => {
                    console.error(error);
                });
                setShowEditForm(false);

        };

          const {
        estado,
        handleEstadoChange,
        handleSubmit,
    } = useEditAdjudicacion(adjudicacion);

    // Add a function to handle the delete button click
    const handleDelete = () => {
        if (window.confirm('Estas seguro que quieres eliminar esta adjudicacion?')) {
            axios.delete(`http://localhost:8080/adjudicaciones/${id}`)
                .then(response => {
                    console.log('Adjudicacion eliminada correctamente');
                    window.location.replace('/adjudicaciones');
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
                        <h1>Adjudicacion</h1>
                    </div>
                    <Sidebar />

                    
                </div>

        <div className="content">
            
        <div className="propuesta-details">
        <div className="propuesta-card">
          <h2>{adjudicacion.propuesta.titulo}</h2>
          <p>{adjudicacion.propuesta.descripcion}</p>
          <p>Profesor: {adjudicacion.propuesta.profesor.nombre} {adjudicacion.propuesta.profesor.apellidos}</p>
          <p>Departamento: {adjudicacion.propuesta.departamento}</p>
          <p>Estado: {adjudicacion.estado}</p>

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
            <label><h2>Edita el estado de la adjudicacion</h2></label>
            <label>
              Estado : 
              <input
                type="text"
                value={estado}
                onChange={handleEstadoChange}
              />
            </label>
            <button type="submit" onClick={upload}>Save</button>
          </form>
        </div>
      )}
        </div>

      
    );
}


function useEditAdjudicacion(adjudicacion) {
    const [estado, setEstado] = useState(adjudicacion.estado);
  
    const handleEstadoChange = (event) => {
      setEstado(event.target.value);
    };
  
  
    const handleSubmit = (event) => {
      event.preventDefault();
      // Do something with the updated adjudicacion data
    };
  
    return {
      estado,
      handleEstadoChange,
      handleSubmit,
    };
  }

export default AdjudicacionDetails;
