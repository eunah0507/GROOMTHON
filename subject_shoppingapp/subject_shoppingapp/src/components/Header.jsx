import React from 'react';
import { NavLink } from 'react-router-dom';
import Container from 'react-bootstrap/Container'

export const Header = () => {
  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-white py-3 shadow-sm">
        <div className="container">
          <NavLink className="navbar-brand fw-bold fs-2" to="/">
            Shop
          </NavLink>
          <div className="buttons">
            <NavLink to="login" className="btn btn-outline-dark">
              <i className="fa-solid fa-right-to-bracket me-1"></i> Login</NavLink>
              <NavLink to="/register" className="btn btn-outline-dark ms-2">
              <i className="fa-solid fa-user-plus me-1"></i> Register</NavLink>
              <NavLink to="/cart" className="btn btn-outline-dark ms-2">
                <span className='p1 fa-2x fa-stack has-badge' data-count={1}>
              <i className="fa-solid fa-cart-shopping me-1"></i></span> Cart</NavLink>
            </div>
        </div>
      </nav>
    </div>
  );
};

export default Header;
