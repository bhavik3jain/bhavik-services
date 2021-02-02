import React, { Component } from 'react';
import { MDBNavbar, MDBNavbarBrand, MDBNavbarNav, MDBNavItem, MDBNavLink, MDBNavbarToggler, MDBCollapse, MDBContainer }
from 'mdbreact';
import { BrowserRouter as Router } from 'react-router-dom';

class Navbar extends Component {

  state = {
		collapseID: ''
  }

  constructor(props) {
    super(props);
    this.props = props;
  }

  componentDidMount() {
    fetch('/states/')
      .then(results => results.json())
      .then(states => {
        this.setState({
          states: states
        });
    });
  }

toggleCollapse = collapseID => () => {
  this.setState(prevState => ({ collapseID: (prevState.collapseID !== collapseID ? collapseID : '') }));
}

renderLocation() {
  let locations = []
  this.state.states.map((stateData) => {
    locations.push({
      abrev: stateData.state.toLowerCase(),
      state: stateData.name
    })
  })

  let links = locations.map((location) => {
		let path = '/covid/'+location.abrev;
		return <MDBNavItem key={location}><MDBNavLink onClick={this.toggleCollapse('navbarCollapse11')} to={path}>{location.state}</MDBNavLink></MDBNavItem>
  })

  return links

}

render() {
  return (
      <MDBContainer>
        <MDBNavbar color="bg-dark" style={{ marginTop: '20px' }} dark>
          <MDBContainer>
            <MDBNavbarBrand className="white-text">
              Covid19 Dashboard
            </MDBNavbarBrand>
            <MDBNavbarToggler image="https://mdbootstrap.com/img/svg/hamburger3.svg?color=000000" onClick={this.toggleCollapse('navbarCollapse11')} />
            <MDBCollapse id="navbarCollapse11" isOpen={this.state.collapseID} navbar>
              <MDBNavbarNav left>
                <MDBNavItem active>
                  <MDBNavLink onClick={this.toggleCollapse('navbarCollapse11')} to="/">Home</MDBNavLink>
                </MDBNavItem>
                <MDBNavItem>
                  <MDBNavLink onClick={this.toggleCollapse('navbarCollapse11')} to="/covid/us">United States</MDBNavLink>
                </MDBNavItem>
								{this.state && this.state.states && (this.renderLocation())}
              </MDBNavbarNav>
            </MDBCollapse>
          </MDBContainer>
        </MDBNavbar>
      </MDBContainer>
    );
  }
}

export default Navbar;
