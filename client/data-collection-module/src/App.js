import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Navbar from "./components/Navbar";
import Login from "./pages/Login";
import UserDashboard from "./pages/UserDashboard";
import VerifierDashboard from "./pages/VerifierDashBoard";
import AdminDashboard from "./pages/AdminDashboard";
import FileUploadPage from "./pages/FileUploadPage";
import UserFilesPage from "./pages/UserFilesPage";
import ProtectedRoute from "./components/Auth/ProtectedRoute";
import Registeration from "./pages/Registration";
import FileDetailsPage from "./pages/FileDetailsPage";

function App() {
  return (
    <Router >
      <Navbar />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/signout" element={<Registeration />} />
        <Route
          path="/user/dashboard"
          element={
           // <ProtectedRoute roles={["user"]}>
              <UserDashboard />
           // </ProtectedRoute>
          }
        />
        <Route
          path="/verifier/dashboard"
          element={
            <ProtectedRoute roles={["verifier"]}>
              <VerifierDashboard />
            </ProtectedRoute>
          }
        />
        <Route
          path="/admin/dashboard"
          element={
            <ProtectedRoute roles={["admin"]}>
              <AdminDashboard />
            </ProtectedRoute>
          }
        />
        <Route
          path="/user/files"
          element={
           // <ProtectedRoute roles={["user"]}>
              <UserFilesPage />
           // </ProtectedRoute>
          }
        />
        <Route
          path="/user/fileDetails/:documentId"
          element={
           // <ProtectedRoute roles={["user"]}>
              <FileDetailsPage />
          //  </ProtectedRoute>
          }
        />
        <Route
          path="/user/upload"
          element={
           // <ProtectedRoute roles={["user"]}>
              <FileUploadPage />
          //  </ProtectedRoute>
          }
        />
      </Routes>
    </Router>
  );
}

export default App;

