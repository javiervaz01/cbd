import React, { useEffect, useState } from "react";
import axios from "axios";
import Sidebar from "../components/Sidebar";
import "./Styles.css";

function Propuestas() {
  const [propuestas, setPropuestas] = useState([]);

  
    const propuestas3 = axios
      .get("http://localhost:8080/propuestas")
      .then((response) => setPropuestas(response.data))
      .catch((error) => console.error(error));
      debugger;
  

  return (
    <div className="app">
      <Sidebar />

      <div className="content">
        <h1>Propuestas</h1>

        <div className="propuestas">
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
    <div className="propuesta">
      <h3>Título: {propuesta.title}</h3>
      <p>Descripción: {propuesta.description}</p>
      <p>Profesor: {propuesta.profesor.name}</p>
      <p>Subject: {propuesta.departamento}</p>
    </div>
  );
}

export default Propuestas;