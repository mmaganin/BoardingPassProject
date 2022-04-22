import React from 'react'
import { useLocation, Link } from "react-router-dom"

const Ticket = () => {
  const location = useLocation();
  console.log("TICKET: " + location.state)

  return (
    <div>
      Ticket for {location?.state === null ? "loading ticket" : "from: " + location.state[0] + " for: " + location.state[2] + " " + location.state[3]}
    </div>
  )
}

export default Ticket