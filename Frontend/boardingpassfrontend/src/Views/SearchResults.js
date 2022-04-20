import React from 'react'
import {useLocation} from "react-router-dom"

const SearchResults = (props) => {
  const location = useLocation();
  console.log(location.from);
  return (
    <div>SearchResults</div>
  )
}

export default SearchResults