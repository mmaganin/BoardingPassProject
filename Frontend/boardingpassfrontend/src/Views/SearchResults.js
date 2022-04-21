import React, { useEffect, useState } from 'react'
import { useLocation } from "react-router-dom"

const SearchResults = () => {
  const location = useLocation();
  const [data, setData] = useState(null);
  const [fetchData, setFetch] = useState(false);

  useEffect(() => {
    if (fetchData) {
      const payload = {
        method: 'GET',
        body: JSON.stringify({from_location: location?.state?.from, departure_time: location?.state?.dateTime})
      }
      fetch('http://localhost:8080/searchresults')
        .then(response => response.json())
        .then(data => setData(data.id));
    }
  }, [fetchData]);

  console.log(data)
  return (
    <div>SearchResults for {useLocation().state}</div>
  )
}

export default SearchResults