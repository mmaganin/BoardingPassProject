import React from 'react'
import {useLocation} from "react-router-dom"

const SearchResults = (props) => {
  return (
    <div>SearchResults for {useLocation().state}</div>
  )
}

export default SearchResults