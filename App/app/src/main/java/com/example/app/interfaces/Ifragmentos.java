package com.example.app.interfaces;

import com.example.app.fragmentos.consultarLista;
import com.example.app.fragmentos.consultarMembro;
import com.example.app.fragmentos.registrarMembro;

public interface Ifragmentos extends
        consultarMembro.OnFragmentInteractionListener,
        consultarLista.OnFragmentInteractionListener,
        registrarMembro.OnFragmentInteractionListener{
}
