import React from "react";
import { Navigate } from "react-router-dom";
import { useSelector } from "react-redux";

const ProtectedRoute = ({ children, roles }) => {
  
  const { role, token } = useSelector((state) => state.auth);
  if (!token) {
    return <Navigate to="/signin" />;
  }

  if (!roles.includes(role)) {
    return <Navigate to="/" />;
  }

  return children;
};

export default ProtectedRoute;
