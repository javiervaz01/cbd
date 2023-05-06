import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Propuestas from './pages/Propuestas';
import Profesores from './pages/Profesores';
import Alumnos from './pages/Estudiantes';
import NotFound from './components/notFound/NotFound';

import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Adjudicaciones from './pages/Adjudicaciones';
import PropuestaDetails from './pages/Propuesta';
import AdjudicacionDetails from './pages/Adjudicacion';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <Routes>
          <Route path="/*" element={<App />} />
          <Route path="/adjudicaciones*" element={<Adjudicaciones />} />
          <Route path="/propuestas*" element={<Propuestas />} />
          <Route path="/profesores*" element={<Profesores />} />
          <Route path="/alumnos*" element={<Alumnos />} />
          <Route path="/ayuda*" element={<NotFound />} />
          <Route path="/propuestas/:id" element={<PropuestaDetails/>} />
          <Route path="/adjudicaciones/:id" element={<AdjudicacionDetails/>} />
        </Routes>
    </BrowserRouter>
  </React.StrictMode>
);
