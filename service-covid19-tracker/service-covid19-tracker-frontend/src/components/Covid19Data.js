import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import GridList from '@material-ui/core/GridList';
import GridListTile from '@material-ui/core/GridListTile';

import CovidCard from './Card';
import CovidChart from './Chart';

function Covid(props) {
  const useStyles = makeStyles((theme) => ({
    root: {
      display: 'flex',
      flexWrap: 'wrap',
      justifyContent: 'space-around',
      overflow: 'hidden',
      backgroundColor: '#c1d5e0',
    },
    gridList: {
      flexWrap: 'nowrap',
      // Promote the list into his own layer on Chrome. This cost memory but helps keeping high FPS.
      transform: 'translateZ(0)',
  		backgroundColor: '#c1d5e0'
    },
    title: {
      color: theme.palette.primary.light,
    },
    titleBar: {
      background:
        'linear-gradient(to top, rgba(0,0,0,0.7) 0%, rgba(0,0,0,0.3) 70%, rgba(0,0,0,0) 100%)',
    },
  }));

  const classes = useStyles();

  let state = props.location == 'us' ? null : props.location

  let positiveIncrease = {
    type: "positiveIncrease",
    avatar: 'C',
    text: 'Cases',
    responseField: 'totalCases',
    chartText: 'New Cases Over 30 Days',
    apiCall: {
      select: {
        state: state,
        types: [
          'CASES'
        ]
      },
      where: {
        dateRange: {
          period: 'LAST_30_DAYS'
        }
      }
    }
  }

  let deathIncrease = {
    type: "deathIncrease",
    avatar: 'D',
    text: 'Deaths',
    responseField: 'totalDeaths',
    chartText: 'New Deaths Over 30 Days',
    apiCall: {
      select: {
        state: state,
        types: [
          'DEATHS'
        ]
      },
      where: {
        dateRange: {
          period: 'LAST_30_DAYS'
        }
      }
    }
  }

  let hospitalizedIncrease = {
    type: "hospitalizedCurrently",
    avatar: 'H',
    text: 'Hospitalizations',
    responseField: 'currentHospitalizations',
    chartText: 'New Hospitalizations Over 30 Days',
    apiCall: {
      select: {
        state: state,
        types: [
          'HOSPITALIZED'
        ]
      },
      where: {
        dateRange: {
          period: 'LAST_30_DAYS'
        }
      }
    }
  }

  let getData = [positiveIncrease, deathIncrease, hospitalizedIncrease]

	let nums = Array.from(getData.keys());

  return (
		<div>
			<div className={classes.root}>
				<GridList className={classes.gridList} cols={3} cellHeight={'auto'}>
					{nums.map(n => {
						return (
							<GridListTile key={n}>
								<CovidCard
                    key={n}
                    type={getData[n].type}
                    text={getData[n].text}
                    location={props.location}
                    avatarText={getData[n].avatar}
                />
							</GridListTile>
						);
					})}
				</GridList>
			</div>
      <div>
        <br/>
      </div>
			<div>
			<GridList className={classes.gridList} cols={3} cellHeight={'auto'}>
				{nums.map(n => {
					return (
						<GridListTile key={n}>
							<CovidChart
                apiCall={getData[n].apiCall}
                responseField={getData[n].responseField}
                chartText={getData[n].chartText}
              />
						</GridListTile>
					);
				})}
			</GridList>
			</div>
		</div>
  );
}

export default Covid;
