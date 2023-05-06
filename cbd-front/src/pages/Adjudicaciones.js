import React, { useEffect, useState } from "react";
import axios from "axios";
import Sidebar from "../components/Sidebar";
import "./Styles.css";
import { Link } from "react-router-dom";
import NewAdjudicacionButton from "./CreateAdjudicacion";

function Adjudicaciones() {
    const [adjudicaciones, setAdjudicaciones] = useState([]);

    useEffect(() => {
      axios.get('http://localhost:8080/adjudicaciones')
        .then(response => {
          setAdjudicaciones(response.data);
          console.log(response.data)
        })
        .catch(error => {
          console.log(error);
        });
    }, []);

  return (
    <div className="app">
      <NewAdjudicacionButton/>
      <div className="right">
                <div className="titulo">
                    <h1>Adjudicaciones</h1>
                </div>
                <Sidebar />

                
            </div>

      <div className="content">
        <div className="provisional"></div>
        <div className="adjudicacion">
          {adjudicaciones.map((adjudicacion) => (
            <AdjudicacionComponent key={adjudicacion.propuesta.titulo} adjudicacion={adjudicacion} />
          ))}
        </div>
      </div>
    </div>
  );
}

function AdjudicacionComponent({ adjudicacion }) {
  return (
    <Link to={`/adjudicaciones/${adjudicacion.id}`}>
    <div className="adjudicacion">
      <h3>Título: {adjudicacion.propuesta.titulo}</h3>
      <p>Descripción: {adjudicacion.propuesta.descripcion}</p>
      <p>Profesor: {adjudicacion.propuesta.profesor.nombre + " " +adjudicacion.propuesta.profesor.apellidos}</p>
      <p>Alumno: {adjudicacion.alumno.nombre + " " +adjudicacion.alumno.apellidos}</p>
      <p>Estado: {JSON.parse(adjudicacion.estado).estado}</p>
      <p className="circle">{adjudicacion.propuesta.departamento}</p>
    </div>
    </Link>
  );
}

export default Adjudicaciones;