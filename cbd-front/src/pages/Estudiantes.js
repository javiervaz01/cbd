import React, { useEffect, useState } from "react";
import axios from "axios";
import Sidebar from "../components/Sidebar";
import "./Styles.css";

function Estudiantes() {
    const [estudiantes, setEstudiantes] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/alumnos')
            .then(response => {
                setEstudiantes(response.data);
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
                    <h1>Estudiantes</h1>
                </div>
                <Sidebar />

                
            </div>
            <div className="content">

                <p></p>

                <div className="contentEstudiante">
                    {estudiantes.map((estudiante) => (
                        <EstudianteComponent key={estudiante.dni} estudiante={estudiante} />
                    ))}
                </div>
            </div>
        </div>
    );
}

function EstudianteComponent({ estudiante }) {
    return (
        <div className="estudiante">
            <h3>Nombre: {estudiante.nombre}</h3>
            <p>Apellidos: {estudiante.apellidos}</p>
            <p>Email: {estudiante.email}</p>
            <p>Telefono: {estudiante.telefono}</p>
            <p>Dni: {estudiante.dni}</p>
            <p>Titulación: {estudiante.titulacion}</p>
            <p className="circle"></p>
        </div>
    );
}

export default Estudiantes;