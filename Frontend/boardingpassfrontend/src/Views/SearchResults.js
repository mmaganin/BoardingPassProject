import React, { useEffect, useState } from 'react'
import { useLocation } from "react-router-dom"

const SearchResults = () => {
  const location = useLocation();
  const [data, setData] = useState(null);
  const [fetchData, setFetch] = useState(true);

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
    <div>SearchResults for {location.state}: {data === null ? "loading" : "success"}</div>
  )
}

export default SearchResults