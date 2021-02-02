import React, { useState, useEffect } from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardHeader from '@material-ui/core/CardHeader';
import CardContent from '@material-ui/core/CardContent';
import Avatar from '@material-ui/core/Avatar';
import Typography from '@material-ui/core/Typography';
import { red, indigo, green } from '@material-ui/core/colors';


function CovidCard(props) {

  const [covidDaily, setCovidDaily] = useState(null)

  useEffect(() => {
    let state = props.location == 'us' ? '' : props.location

    fetch('http://api.thebhavikjain.com/analytics/read_analytics/?state='+state)
      .then(results => {
        return results.json()
      })
      .then(covid_daily => {
        setCovidDaily(covid_daily);
      });
  }, []);

  const useStyles = makeStyles((theme) => ({
    root: {
      color: '#cfd8dc'
    },
    cardHeader: {
      backgroundColor: '#d32f2f',
    },
    cardContent: {
      backgroundColor: '#02579b',
    },
    avatar: {
      backgroundColor: '#487e4c',
    },
  }));

  const classes = useStyles();

  return (
    covidDaily &&
    <Card className={classes.root}>
      <CardHeader
        className={classes.cardHeader}
        avatar={
          <Avatar aria-label={props.avatarText} className={classes.avatar}>
            {props.avatarText}
          </Avatar>
        }
        title={props.text}
        subheader={covidDaily.date}
      />
      <CardContent className={classes.cardContent}>
        <Typography variant="h6" color="textPrimary" component="p" align='center'>
          {covidDaily[props.type]}
        </Typography>
      </CardContent>
    </Card>
  );

}

export default CovidCard;
