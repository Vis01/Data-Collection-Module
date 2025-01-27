import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import { logout } from "../features/auth/authSlice";
const Navbar = () => {
  const { isAuthenticated, role } = useSelector((state) => state.auth);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const handleLogout = () => {
    dispatch(logout());
    navigate("/login");
  };

  return (
    <nav className="bg-gray-800 text-white shadow-md">
      <div className="max-w-7xl mx-auto px-4 py-3 flex justify-between items-center">
        {/* Logo */}
        <Link to="/" className="text-xl font-bold text-blue-300 hover:text-blue-400">
          MyApp
        </Link>

        {/* Links */}
        <div className="flex items-center space-x-4">
          {isAuthenticated ? (
            <>
              {/* Conditional navigation based on role */}
              {role === "admin" && <Link to="/admin/dashboard" className="hover:text-blue-400">Admin Dashboard</Link>}
              {role === "verifier" && <Link to="/verifier/dashboard" className="hover:text-blue-400">Verifier Dashboard</Link>}
              {role === "user" && <Link to="/user/dashboard" className="hover:text-blue-400">User Dashboard</Link>}

              {/* Logout Button */}
              <button
                onClick={handleLogout}
                className="flex items-center px-4 py-2 bg-blue-500 hover:bg-blue-600 rounded-md transition"
              >
                
                Logout
              </button>
            </>
          ) : (
            <>
              {/* Guest Navigation */}
              <Link to="/login" className="hover:text-blue-400">Login</Link>
              <Link to="/register" className="hover:text-blue-400">Register</Link>
            </>
          )}
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
