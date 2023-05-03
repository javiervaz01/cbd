import logo from './logo.svg';
import './App.css';
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './pages/home';

function App() {
  return (
    <Routes>
        <Route exact path="/" component={HomePage} />

    </Routes>
  );
}

export default App;
