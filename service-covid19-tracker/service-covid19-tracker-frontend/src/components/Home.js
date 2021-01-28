import React, {Component} from 'react';
import '../styles/home.css';
import kronos from '../images/covid-19.png';


class Home extends Component {

	render() {
		return (
			<div className={"center-screen"}>
				<img className={"center-fit"} src={kronos} alt={""}/>
			</div>
		)
	}
}

export default Home;
