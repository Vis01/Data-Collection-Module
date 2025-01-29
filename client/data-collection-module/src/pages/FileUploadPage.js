import React, { useState } from "react";
import { useSelector } from "react-redux";
import api from "../services/api"; // Use the API service
import languages from "../data/languages.json"; // Load languages from JSON

const FileUploadPage = () => {
  const [sourceLanguage, setSourceLanguage] = useState("");
  const [targetLanguage, setTargetLanguage] = useState("");
  const [fileType, setFileType] = useState("");
  const [file, setFile] = useState(null);
  const [error, setError] = useState("");
  const [message, setMessage] = useState("");

  // User ID from Redux store
  const userId =1 ;// useSelector((state) => state.auth.user?.id);

  // Handle form submission
  const handleSubmit = async (e) => {
    e.preventDefault();
  
    // Validation for source and target languages
    if (sourceLanguage === targetLanguage) {
      setError("Source and target languages cannot be the same.");
      return;
    }
  
    // Ensure all fields are filled
    if (!sourceLanguage || !targetLanguage || !fileType || !file) {
      setError("Please fill out all fields and upload a file.");
      return;
    }
  
    setError(""); // Clear error messages if validation passes
  
    // Prepare form data
    const formData = new FormData();
    formData.append("file", file); // Append the file
    formData.append("userId", userId); // Append userId
    formData.append("sourceLanguageId", sourceLanguage); // Append sourceLanguageId
    formData.append("targetLanguageId", targetLanguage); // Append targetLanguageId
  
    try {
      const response = await api.post("/files/upload", formData, {
        headers: {
          "Content-Type": "multipart/form-data", // This can be omitted as Axios handles it automatically
        },
      });
  
      // If the file was uploaded successfully
      setMessage(response.data || "File uploaded and processed successfully!");
    } catch (error) {
      console.error("Error:", error);
      setError("Error uploading file. Please try again.");
    }
  };
  

  return (
    <div className="min-h-screen bg-gray-50 flex flex-col items-center py-8">
      <h1 className="text-3xl font-bold mb-8">Upload File</h1>
      <form
        onSubmit={handleSubmit}
        className="bg-white p-6 rounded shadow-md max-w-md w-full"
      >
        {/* Source Language */}
        <div className="mb-4">
          <label className="block text-sm font-medium mb-2">Source Language</label>
          <select
            value={sourceLanguage}
            onChange={(e) => setSourceLanguage(e.target.value)}
            className="w-full px-3 py-2 border rounded focus:outline-none"
          >
            <option value="" disabled>
              Select source language
            </option>
            {languages.map((lang) => (
              <option key={lang.language_id} value={lang.language_id}>
                {lang.language_name}
              </option>
            ))}
          </select>
        </div>

        {/* Target Language */}
        <div className="mb-4">
          <label className="block text-sm font-medium mb-2">Target Language</label>
          <select
            value={targetLanguage}
            onChange={(e) => setTargetLanguage(e.target.value)}
            className="w-full px-3 py-2 border rounded focus:outline-none"
          >
            <option value="" disabled>
              Select target language
            </option>
            {languages.map((lang) => (
              <option key={lang.language_id} value={lang.language_id}>
                {lang.language_name}
              </option>
            ))}
          </select>
        </div>

        {/* File Type */}
        <div className="mb-4">
          <label className="block text-sm font-medium mb-2">File Type</label>
          <select
            value={fileType}
            onChange={(e) => setFileType(e.target.value)}
            className="w-full px-3 py-2 border rounded focus:outline-none"
          >
            <option value="" disabled>
              Select file type
            </option>
            <option value="pdf">PDF</option>
            <option value="doc">Word Document</option>
            <option value="txt">Text File</option>
            <option value="excel">Excel Sheet</option>
          </select>
        </div>

        {/* File Upload */}
        <div className="mb-4">
          <label className="block text-sm font-medium mb-2">Upload File</label>
          <input
            type="file"
            onChange={(e) => setFile(e.target.files[0])}
            className="w-full px-3 py-2 border rounded focus:outline-none"
          />
        </div>

        {/* Submit Button */}
        <button
          type="submit"
          className="w-full bg-blue-500 text-white py-2 rounded hover:bg-blue-600 transition"
        >
          Upload
        </button>

        {/* Error Message */}
        {error && (
          <p className="mt-4 text-center text-sm text-red-500">{error}</p>
        )}

        {/* Success Message */}
        {message && (
          <p className="mt-4 text-center text-sm text-green-500">{message}</p>
        )}
      </form>
    </div>
  );
};

export default FileUploadPage;
