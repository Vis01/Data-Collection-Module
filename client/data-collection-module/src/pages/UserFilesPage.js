import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import api from '../services/api';

const UserFilesPage = () => {
    const [documents, setDocuments] = useState([]);
    const userId=1;
    useEffect(() => {
        // Fetch the documents from the API
        api.get(`/documents/user/${userId}`) // Replace with your actual endpoint
            .then(response=> {
              console.log(response.data);
              setDocuments(response.data)}
            )
            .catch(error => console.error('Error fetching documents:', error));
    }, []);

    const getStatusColor = (status) => {
        switch (status) {
            case 'verified':
                return 'bg-green-500';
            case 'pending':
                return 'bg-yellow-500';
            case 'rejected':
                return 'bg-red-500';
            default:
                return 'bg-gray-500';
        }
    };

    return (
      <div className="container mx-auto p-6">
      <h1 className="text-3xl font-semibold mb-4">Document List</h1>
      <table className="min-w-full table-auto">
        <thead>
          <tr>
            <th className="px-4 py-2 text-left">ID</th>
            <th className="px-4 py-2 text-left">File Name</th>
            <th className="px-4 py-2 text-left">Uploaded Date</th>
            <th className="px-4 py-2 text-left">Status</th>
            <th className="px-4 py-2 text-left">Verifier ID</th>
          </tr>
        </thead>
        <tbody>
          {documents.map((document) => (
            <tr
              key={document.documentId}
              className="border-t hover:bg-gray-100 transition duration-200"
            >
              <td className="px-4 py-2">
                <Link to={`/user/fileDetails/${document.documentId}`} className="text-blue-500">
                  {document.documentId}
                </Link>
              </td>
              <td className="px-4 py-2">
                <Link to={`/user/fileDetails/${document.documentId}`} className="text-blue-500">
                  {document.fileName}
                </Link>
              </td>
              <td className="px-4 py-2">
                <Link to={`/user/fileDetails/${document.documentId}`} className="text-blue-500">
                  {new Date(document.uploadDate).toLocaleDateString()}
                </Link>
              </td>
              <td
                className={`px-4 py-2 text-white ${getStatusColor(document.status)}`}
              >
                <Link to={`/user/fileDetails/${document.documentId}`} className="text-white">
                  {document.status}
                </Link>
              </td>
              <td className="px-4 py-2">
                <Link to={`/user/fileDetails/${document.documentId}`} className="text-blue-500">
                  {document.verifierId || "N/A"}
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
    );
};

export default UserFilesPage;
