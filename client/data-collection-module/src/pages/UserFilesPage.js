import React from "react";

const UserFilesPage = () => {
  // Dummy file data for example
  const files = [
    { id: 1, name: "File1.pdf", status: "Pending" },
    { id: 2, name: "File2.docx", status: "Approved" },
  ];

  return (
    <div className="p-4">
      <h1 className="text-2xl font-bold mb-4">My Files</h1>
      <table className="table-auto w-full border">
        <thead>
          <tr>
            <th className="border px-4 py-2">File Name</th>
            <th className="border px-4 py-2">Status</th>
          </tr>
        </thead>
        <tbody>
          {files.map((file) => (
            <tr key={file.id}>
              <td className="border px-4 py-2">{file.name}</td>
              <td className="border px-4 py-2">{file.status}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default UserFilesPage;
