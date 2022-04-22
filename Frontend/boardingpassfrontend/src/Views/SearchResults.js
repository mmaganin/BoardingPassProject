import React, { useEffect, useState } from 'react'
import { useLocation, Link } from "react-router-dom"
import {
  Box, Button, CircularProgress, Grid, Card, CardActionArea,
  CardMedia, CardContent, Typography, FormControl, RadioGroup, FormControlLabel, Radio, FormGroup, Checkbox, InputLabel, Select, MenuItem
} from '@mui/material'

const SearchResults = () => {
  const location = useLocation();
  const [data, setData] = useState(null);
  const [fetchData, setFetch] = useState(true);

  // from={this.state.from}
  // dateTime={this.state.date}
  // firstName={this.state.firstName}
  // lastName={this.state.lastName}
  // email={this.state.email}
  // phoneNumber={this.state.phoneNumber}
  // age={this.state.age}
  // selectedGender={this.state.selectedGender}

  console.log(location?.state)

  const json = JSON.stringify({ from_location: location?.state[0], departure_time: location?.state[1] })
  console.log(json)

  useEffect(() => {
    if (fetchData) {
      const payload = {
        method: 'POST',
        headers: {
          "Content-Type": "application/json"
        },
        body: json
      }
      fetch('http://localhost:8080/searchresults', payload)
        .then(response => response.json())
        .then(data => setData(data));
    }
  }, [fetchData]);



  console.log(data)
  return (
    <div>
      <p>{location.state[2]} {location.state[3]}, Here are your search results for stop</p>
      <p>{location.state[0]} at time {location.state[1]},</p>
      <p>Select one of the options to generate a boarding ticket.</p>
      <Grid container spacing={2} >
        {data != null && data.length != 0
          ?
          data.map((dataIdx) => getCard(dataIdx, location.state))
          :
          <div>Loading Search Results...</div>
        }
      </Grid>
    </div>
  )
}

function getCard(dataIdx, state) {
  return (
    <Grid
      item
      xs={12}
      md={3}
    >
      <Card>
        <CardActionArea component={Link} to={"/ticket"} state={state}>

          <CardContent sx={{ display: "flex", flexDirection: "column", alignItems: "flex-start" }}>
            <Typography gutterBottom noWrap component="div">
              {dataIdx.stop.stop_name}
            </Typography>
            <Typography noWrap variant="body2" color="text.secondary" component="div">
              {"Departure Time: " + dataIdx.depart_time + ", ETA: " + dataIdx.eta}
            </Typography>
          </CardContent>
        </CardActionArea>
      </Card>
    </Grid>
  )

}

export default SearchResults