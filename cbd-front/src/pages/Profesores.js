import React, { useEffect, useState } from "react";
import axios from "axios";
import Sidebar from "../components/Sidebar";
import "./Styles.css";

function Profesores() {
    const [profesores, setProfesores] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/profesores')
            .then(response => {
                setProfesores(response.data);
                console.log(response.data)
            })
            .catch(error => {
                console.log(error);
            });
    }, []);

    return (
        <div className="app">
            <div className="right">
                <div className="titulo">
                    <h1>Profesores</h1>
                </div>
                <Sidebar />

                
            </div>
            <div className="content">

                <p></p>

                <div className="contentProfesor">
                    {profesores.map((profesor) => (
                        <ProfesorComponent key={profesor.nombre} profesor={profesor} />
                    ))}
                </div>
            </div>
        </div>
    );
}

function ProfesorComponent({ profesor }) {
    return (
        <div className="profesor">
            <h3>Nombre: {profesor.nombre}</h3>
            <p>Apellidos: {profesor.apellidos}</p>
            <p>Email: {profesor.email}</p>
            <p>Telefono: {profesor.telefono}</p>
            <p>Departamento: {profesor.departamento}</p>
            <p className="circle"></p>
        </div>
    );
}

export default Profesores;