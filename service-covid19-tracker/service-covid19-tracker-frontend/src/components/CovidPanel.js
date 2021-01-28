import React, {
  Component
} from "react";
import Covid from './Covid19Data';

class CovidPanel extends Component {

  state = {};

  constructor(props) {
    super(props);
    this.props = props;
  }

  componentDidUpdate(previousProps) {
    if (previousProps.match.params.location !== this.props.match.params.location) {
      window.location.reload();
    }
  }

  componentDidMount() {

  }

  render() {
    return (
      <div>
        <Covid location={this.props.match.params.location}/>
      </div>

    );
  }
}

export default CovidPanel;
