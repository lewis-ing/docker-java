package com.github.dockerjava.core.command;

import com.github.dockerjava.api.NotFoundException;
import com.github.dockerjava.api.command.PauseContainerCmd;

import com.google.common.base.Preconditions;

/**
 * Pause a container.
 *
 * @param containerId - Id of the container
 *
 */
public class PauseContainerCmdImpl extends AbstrDockerCmd<PauseContainerCmd, Void> implements PauseContainerCmd {

	private String containerId;

	public PauseContainerCmdImpl(PauseContainerCmd.Exec exec, String containerId) {
		super(exec);
		withContainerId(containerId);
	}

    @Override
	public String getContainerId() {
        return containerId;
    }

    @Override
	public PauseContainerCmd withContainerId(String containerId) {
		Preconditions.checkNotNull(containerId, "containerId was not specified");
		this.containerId = containerId;
		return this;
	}

	@Override
    public String toString() {
        return new StringBuilder("pause ")
            .append(containerId)
            .toString();
    }
	
	/**
	 * @throws NotFoundException No such container
	 */
	@Override
	public Void exec() throws NotFoundException {
		return super.exec();
	}
}
