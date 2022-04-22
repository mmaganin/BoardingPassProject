import React, { useEffect, useState } from 'react'
import { useLocation, Link } from "react-router-dom"
import { Box, Button, Grid, Card, CardContent, Typography, Stack } from '@mui/material';

const Ticket = () => {
  const location = useLocation();
  const [data, setData] = useState(null);
  const [fetchData, setFetch] = useState(true);

  const customerInfo = location.state.customerInfo
  const dataIdx = location.state.dataIdx
  const json = JSON.stringify({
    ticketid: "0", calendar_date: customerInfo[1], origin: customerInfo[0], destination: dataIdx.stop.stop_name, eta: dataIdx.eta,
    departure_time: customerInfo[1], name: customerInfo[2] + " " + customerInfo[3], email: customerInfo[4], 
    phone_number: customerInfo[5], gender: customerInfo[7], age: customerInfo[6], total_ticket_price: "0"
  })

  useEffect(() => {
    if (fetchData) {
      const payload = {
        method: 'POST',
        headers: {
          "Content-Type": "application/json"
        },
        body: json
      }
      fetch('http://localhost:8080/ticket', payload)
        .then(response => response.json())
        .then(data => setData(data));
    }
  }, [fetchData]);

  return (
    <div style={{ display: "flex", justifyContent: "center" }}>
      {data != null ?
        <Box>
          {getProfile(data)}
          {/* <Theme /> */}
        </Box>
        :
        <div>Loading Ticket...</div>
      }
    </div>
  )
}

function getProfile(ticket) {
  var formatter = new Intl.NumberFormat('en-US', {
    style: 'currency',
    currency: 'USD',
  });
  return (
    <Box
      display="flex"
      alignSelf="center"
      flexDirection="column"
      alignItems="center"
      pt="8px"
      maxWidth="1200px"
      margin="56px 16px"
    >
      <Grid
        container
        id="top-page-container"
        spacing={2}
        sx={{ minWidth: { md: "900px" } }}
      >
  
        <Grid
          item
          id="details-container"
          xs={12}
          md={6}
        >
          <Box
            id="title-container"
            display="flex"
            flexDirection="column"
            alignItems="flex-start"
            justifyContent="flex-start"
            pl="16px"
          >
            <Box
              display="flex"
              alignItems="center"
              justifyContent="space-between"
              width="100%"
              pb="32px"
            >
              <h1 style={{ fontWeight: 300, margin: "0px" }}>Boarding Pass #: {ticket.ticketid}</h1>


            </Box>

            <Box
              display="flex"
              flexDirection="column"
              alignItems="flex-start"
              pb="24px"
            >
              <strong style={{ paddingBottom: "8px" }}>Name</strong>
              <span>{ticket.name}</span>
            </Box>
            <Box
              display="flex"
              flexDirection="column"
              alignItems="flex-start"
              pb="24px"
            >
              <strong style={{ paddingBottom: "8px" }}>Origin, Destination</strong>
              <span style={{ paddingBottom: "4px" }}>{ticket.origin}, {ticket.destination}</span>
            </Box>

          </Box>
        </Grid>
      </Grid>

      <hr style={{ width: "100%", border: "1px solid lightgrey", margin: "40px 0px 28px" }} />
      <h1 style={{ fontWeight: 300, margin: "0px 0px 16px", alignSelf: "flex-start" }}>Your Info</h1>
      <Box alignSelf="flex-start">Email: {ticket.email}, Phone Number: {ticket.phone_number}, Gender: {ticket.gender}, Age: {ticket.age}</Box>

      <h1 style={{ fontWeight: 300, margin: "24px 0px 16px", alignSelf: "flex-start" }}>Date Departure Time, ETA</h1>
      <Box alignSelf="flex-start">{ticket.departure_time}, {ticket.eta}</Box>

      <hr style={{ width: "100%", border: "1px solid lightgrey", margin: "40px 0px 28px" }} />
      <h1 style={{ fontWeight: 300, margin: "24px 0px 16px", alignSelf: "flex-start" }}>Price: {formatter.format(ticket.total_ticket_price)}</h1>
      <Box alignSelf="flex-start">Discount: {formatter.format(2.75 - ticket.total_ticket_price)}</Box>

    </Box>
  )
}

export default Ticket