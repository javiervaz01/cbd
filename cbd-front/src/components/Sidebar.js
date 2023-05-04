import React from "react";
import { Link } from "react-router-dom";
import "./Sidebar.css";

const Sidebar = () => {
  return (
    <div className="sidebar">
      <Link to="/" className="sidebar-item">
        Home
      </Link>
      <Link to="/propuestas" className="sidebar-item">
        Propuestas
      </Link>
      <Link to="/adjudicaciones" className="sidebar-item">
        Adjudicaciones
      </Link>
      <Link to="/profesores" className="sidebar-item">
        Profesores
      </Link>
      <Link to="/alumnos" className="sidebar-item">
        Alumnos
      </Link>
      <Link to="/ayuda" className="sidebar-item">
        Ayuda
      </Link>
    </div>
  );
};

export default Sidebar;
