import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import api from '../services/api';

const FileDetailsPage = () => {
    const { documentId } = useParams(); // Fetch documentId from the URL
    const [sentences, setSentences] = useState([]);

    useEffect(() => {
        // Fetch the sentences for the specific document
        api.get(`/sentences/document/${documentId}`) // Replace with your actual endpoint
            .then(response => {
              console.log(response.data)
              setSentences( response.data)})
            .catch(error => console.error('Error fetching sentences:', error));
    }, [documentId]);

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
            <h1 className="text-3xl font-semibold mb-4">Sentences for Document {documentId}</h1>
            <table className="min-w-full table-auto">
                <thead>
                    <tr>
                        <th className="px-4 py-2 text-left">ID</th>
                        <th className="px-4 py-2 text-left">Sentence (Source Language)</th>
                        <th className="px-4 py-2 text-left">Translation</th>
                        <th className="px-4 py-2 text-left">Status</th>
                    </tr>
                </thead>
                <tbody>
                    {sentences?.map((sentence) => (
                        <tr key={sentence?.sentenceId} className="border-t">
                            <td className="px-4 py-2">{sentence?.sentenceId}</td>
                            <td className="px-4 py-2">{sentence?.originalSentence}</td>
                            <td className="px-4 py-2">{sentence?.translation || 'N/A'}</td>
                            <td className={`px-4 py-2 text-white ${getStatusColor(sentence?.status)}`}>
                                {sentence?.status}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
};
export default FileDetailsPage