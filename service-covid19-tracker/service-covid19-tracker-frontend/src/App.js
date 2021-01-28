import React, {Component} from 'react';
import 'react-confirm-alert/src/react-confirm-alert.css';
import {BrowserRouter, Route, Switch} from 'react-router-dom';
import './App.css';

import CovidPanel from './components/CovidPanel';
import Navigation from './components/Navigation';
import Home from './components/Home';


class App extends Component {

	constructor(props) {
    super(props);
  }

	render() {
		return (
			<div>
				<BrowserRouter>
					<div>
						<div>
							<Navigation/>
						</div>
						<div>
							<br/>
						</div>
						<div>
							<Switch>
								<Route path="/" component={Home} exact/>
								<Route path="/covid/:location" render={(props) => <CovidPanel {...props} />}/>
							</Switch>
						</div>
					</div>
				</BrowserRouter>
			</div>
		);
	}
}

export default App;
