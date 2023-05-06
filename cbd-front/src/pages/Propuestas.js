import React, { useEffect, useState } from "react";
import axios from "axios";
import Sidebar from "../components/Sidebar";
import "./Styles.css";
import { Link } from 'react-router-dom';
import NewPropuestaButton from "./CreatePropuesta";

function Propuestas() {
    const [propuestas, setPropuestas] = useState([]);

    useEffect(() => {
      axios.get('http://localhost:8080/propuestas')
        .then(response => {
          setPropuestas(response.data);
          console.log(response.data)
        })
        .catch(error => {
          console.log(error);
        });
    }, []);

  return (
    <div className="app">
      <NewPropuestaButton/>
      <div className="right">
                <div className="titulo">
                    <h1>Propuestas</h1>
                </div>
                <Sidebar />

                
            </div>

      <div className="content">
        <div className="provisional"></div>
        <div className="propuesta">
          {propuestas.map((propuesta) => (
            <PropuestaComponent key={propuesta.titulo} propuesta={propuesta} />
          ))}
        </div>
        
      </div>
    </div>
  );
}

function PropuestaComponent({ propuesta }) {
  return (
    <Link to={`/propuestas/${propuesta.id}`}>
    <div className="propuesta">
      <h3>Título: {propuesta.titulo}</h3>
      <p>Descripción: {propuesta.descripcion}</p>
      <p>Profesor: {propuesta.profesor.nombre + " " +propuesta.profesor.apellidos}</p>
      <p className="circle">{propuesta.departamento}</p>
    </div>
    </Link>
  );
}

export default Propuestas;