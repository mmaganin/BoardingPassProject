import React from 'react'
import {useLocation} from "react-router-dom"

const SearchResults = (props) => {
  console.log(props.location)
  const location = useLocation();
  console.log(location)

  return (
    <div>SearchResults + {location.state?.from}</div>
  )
}

export default SearchResults