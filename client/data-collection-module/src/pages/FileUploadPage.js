import React, { useState } from "react";

const FileUploadPage = () => {
  const [file, setFile] = useState(null);

  const handleFileUpload = (e) => {
    setFile(e.target.files[0]);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Logic to send file to the server
    console.log("Uploading file:", file);
  };

  return (
    <div className="p-4">
      <h1 className="text-2xl font-bold mb-4">Upload File</h1>
      <form onSubmit={handleSubmit} className="flex flex-col gap-4">
        <input type="file" onChange={handleFileUpload} />
        <button type="submit" className="bg-blue-500 text-white p-2 rounded">
          Upload
        </button>
      </form>
    </div>
  );
};

export default FileUploadPage;
