import React from 'react'
import {useLocation} from "react-router-dom"

const SearchResults = (props) => {
  const location = useLocation();
  return (
    <div>SearchResults for {location?.state?.from} and {location?.state?.dateTime}</div>
  )
}

export default SearchResults