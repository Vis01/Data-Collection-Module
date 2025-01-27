import React from "react";
import { Link } from "react-router-dom";

const UserDashboard = () => {
  return (
    <div className="p-4">
      <h1 className="text-2xl font-bold mb-4">User Dashboard</h1>
      <div className="flex flex-col gap-4">
        <Link to="/user/files" className="bg-blue-500 text-white p-2 rounded">
          View My Files
        </Link>
        <Link to="/user/upload" className="bg-green-500 text-white p-2 rounded">
          Upload New File
        </Link>
      </div>
    </div>
  );
};

export default UserDashboard;
