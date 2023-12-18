import React from 'react'
import Container from 'react-bootstrap/Container'
import Navbar from 'react-bootstrap/Navbar'
import { NavLink } from 'react-router-dom'
import '../css/style.css'

const Headers = () => {
  return (
    <>
      <Navbar style={{height:"60px", background:"white", color:"black"}}>
        <Container>
        <NavLink className="navbar-brand fw-bold fs-2" to="/">
            Shop
          </NavLink>
          <div id='ex4'>
            <span className='p1 fs-2 fa-stack fa-2x has-badge' data-count={1}>
              <i className='fa-solid fa-cart-shopping'></i>
            </span>
          </div>
        </Container>
      </Navbar>
    </>
  )
}

export default Headers