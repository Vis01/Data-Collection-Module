import { createSlice } from "@reduxjs/toolkit";
import {jwtDecode} from "jwt-decode";

const initialState = {
  user: null,
  token: null,
  role: null,
};

const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    setCredentials: (state, action) => {
      const { token } = action.payload;
      const decodedToken = jwtDecode(token);
      state.user = decodedToken.user;
      state.role = decodedToken.role;
      state.token = token;

      // Store token in localStorage for persistence
      localStorage.setItem("token", token);
    },
    logout: (state) => {
      state.user = null;
      state.role = null;
      state.token = null;
      localStorage.removeItem("token");
    },
  },
});

export const { setCredentials, logout } = authSlice.actions;
export default authSlice.reducer;
