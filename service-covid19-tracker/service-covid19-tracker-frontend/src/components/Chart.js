import React, { Component } from "react";
import Chart from "react-apexcharts";

class CovidChart extends Component {
  state = {};

  constructor(props) {
    super(props);
    this.props = props;
  }

  componentDidMount() {
    const requestOptions = {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(this.props.apiCall),
    };

    fetch("/analytics/multi_read/", requestOptions)
      .then((response) => response.json())
      .then((data) => {
        this.setState({
          data: data[this.props.responseField],
        });
      });
  }

  renderChartData() {
    let categories = [];
    let data = [];

    this.state.data.map((row) => {
      categories.push(row.date);
      data.push(row.value);
    });

    let chartConfig = {
      options: {
        chart: {
          height: 350,
          type: "line",
          dropShadow: {
            enabled: true,
            color: "#000",
            top: 18,
            left: 7,
            blur: 10,
            opacity: 0.2,
          },
          toolbar: {
            show: true,
          },
        },
        colors: ["#545454"],
        dataLabels: {
          enabled: false,
        },
        stroke: {
          curve: "smooth",
        },
        grid: {
          borderColor: "#e7e7e7",
          row: {
            colors: ["#f3f3f3"], // takes an array which will be repeated on columns
            opacity: 0.5,
          },
        },
        xaxis: {
          categories: categories,
          title: {
            text: "Date",
          },
        },
        yaxis: {
          title: {
            text: "Totals",
          },
        },
        title: {
          text: this.props.chartText,
          align: "center",
        },
      },
      series: [
        {
          name: "Covid Data",
          data: data,
        },
      ],
    };

    return (
      <Chart
        options={chartConfig.options}
        series={chartConfig.series}
        type="line"
        width="500"
      />
    );
  }

  render() {
    return (
      <div className="app">
        <div className="row">
          {" "}
          {this.state && this.state.data && (
            <div className="mixed-chart"> {this.renderChartData()} </div>
          )}{" "}
        </div>{" "}
      </div>
    );
  }
}

export default CovidChart;
